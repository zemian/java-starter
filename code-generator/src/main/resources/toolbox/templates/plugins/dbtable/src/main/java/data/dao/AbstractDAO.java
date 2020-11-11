package ${basePackage}.data.dao;

import ${basePackage}.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Base DAO that support data pagination.
 *
 * @Author Zemian Deng 2017
 */
public abstract class AbstractDAO {
    @Value("<#noparse>${app.data.pagingSupport.maxPagingSize:10000}"</#noparse>)
    protected int maxPagingSize;

    @Autowired
    protected JdbcTemplate jdbc;

    /*
    NOTE: To use paging offectively, the "sql" should contains ORDER BY clause between queries!
     */
    protected <T> PagingList<T> findByPaging(String sql, RowMapper<T> rowMapper, Paging paging, Object ... params) {
        if (paging.getOffset() < 0 || paging.getSize() < 1) {
            throw new AppException("Invalid paging values.");
        }

        if (paging.getSize() > maxPagingSize) {
            throw new AppException("Max paging size limit exceeded.");
        }

        String pagingSql = sql + " LIMIT ? OFFSET ?";
        List<Object> paramList = new ArrayList<>();
        for (Object param : params) {
            paramList.add(param);
        }

        paramList.add(paging.getSize() + 1); // We want extra one row to determine hasMore flag
        paramList.add(paging.getOffset());

        List<T> list = jdbc.query(pagingSql, rowMapper, paramList.toArray());
        boolean more = list.size() > paging.getSize();
        if (more) {
            list.remove(list.size() - 1);
        }
        PagingList<T> ret = new PagingList<T>(list, more, paging);
        return ret;
    }
}
