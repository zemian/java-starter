package com.zemian.toolbox.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a DB column attributes retrieved by DatabaseMetaData.getColumns().
 *
 TABLE_CAT String => table catalog (may be null)
 TABLE_SCHEM String => table schema (may be null)
 TABLE_NAME String => table name
 COLUMN_NAME String => column name
 DATA_TYPE int => SQL type from java.sql.Types
 TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified
 COLUMN_SIZE int => column size.
 BUFFER_LENGTH is not used.
 DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable.
 NUM_PREC_RADIX int => Radix (typically either 10 or 2)
 NULLABLE int => is NULL allowed.

 columnNoNulls - might not allow NULL values
 columnNullable - definitely allows NULL values
 columnNullableUnknown - nullability unknown

 REMARKS String => comment describing column (may be null)
 COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
 SQL_DATA_TYPE int => unused
 SQL_DATETIME_SUB int => unused
 CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column
 ORDINAL_POSITION int => index of column in table (starting at 1)
 IS_NULLABLE String => ISO rules are used to determine the nullability for a column.

 YES --- if the column can include NULLs
 NO --- if the column cannot include NULLs
 empty string --- if the nullability for the column is unknown

 SCOPE_CATALOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF)
 SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF)
 SCOPE_TABLE String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF)
 SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF)
 IS_AUTOINCREMENT String => Indicates whether this column is auto incremented

 YES --- if the column is auto incremented
 NO --- if the column is not auto incremented
 empty string --- if it cannot be determined whether the column is auto incremented

 IS_GENERATEDCOLUMN String => Indicates whether this is a generated column

 YES --- if this a generated column
 NO --- if this not a generated column
 empty string --- if it cannot be determined whether th
 */
public class DbField {
    private boolean isKey; // DatabaseMetaData.getPrimaryKeys() if COLUMN_NAME == name

    private String typeName;
    private int dataType = Integer.MIN_VALUE;
    private String columnName;
    private boolean isAutoincrement;
    private boolean nullable;
    private String columnDef;
    private int columnSize = Integer.MIN_VALUE;
    private int bufferLength = Integer.MIN_VALUE;
    private int decimalDigits = Integer.MIN_VALUE;
    private int numPrecRadix = Integer.MIN_VALUE;
    private int ordinalPosition = Integer.MIN_VALUE;
    private boolean isGeneratedcolumn;

    private List<DbRefField> refFields = new ArrayList<>();

    public DbField() {
    }

    public DbField(int dataType, String columnName, boolean nullable) {
        this.dataType = dataType;
        this.columnName = columnName;
        this.nullable = nullable;
    }

    public String getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }

    public int getDataType() {
        return dataType;
    }

    public String getColumnName() {
        return columnName;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isAutoincrement() {
        return isAutoincrement;
    }

    public void setAutoincrement(boolean autoincrement) {
        this.isAutoincrement = autoincrement;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public int getBufferLength() {
        return bufferLength;
    }

    public void setBufferLength(int bufferLength) {
        this.bufferLength = bufferLength;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public int getNumPrecRadix() {
        return numPrecRadix;
    }

    public void setNumPrecRadix(int numPrecRadix) {
        this.numPrecRadix = numPrecRadix;
    }

    public int getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(int ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public boolean isGeneratedcolumn() {
        return isGeneratedcolumn;
    }

    public void setGeneratedcolumn(boolean generatedcolumn) {
        isGeneratedcolumn = generatedcolumn;
    }

    public List<DbRefField> getRefFields() {
        return refFields;
    }

    public void setRefFields(List<DbRefField> refFields) {
        this.refFields = refFields;
    }
}
