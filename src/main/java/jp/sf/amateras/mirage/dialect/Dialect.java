package jp.sf.amateras.mirage.dialect;

import jp.sf.amateras.mirage.annotation.PrimaryKey.GenerationType;
import jp.sf.amateras.mirage.type.ValueType;

public interface Dialect {

    /**
     * Returns the dialect name.
     *
     * @return the dialect name
     */
    String getName();

    /**
     * Returns true if the result set of procedure invocation requires parameter or not.
     *
     * @return true then required, false then not required
     */
    boolean needsParameterForResultSet();

    /**
     * Returns true if a specific primary key generation type is supported.
     * @param generationType the pk generation type
     * @return true if generation type is supported, false otherwise
     */
    boolean supportsGenerationType(GenerationType generationType);

    /**
     * Returns an SQL select to execute the sequence.
     *
     * @param sequenceName the name of the DB Sequence
     * @return an SQL select to execute the sequence
     */
    String getSequenceSql(String sequenceName);

    /**
     * Wraps a select with another to count the rows.
     * @param sql the select to wrap with count
     * @return a select to count the rows
     */
    String getCountSql(String sql);

    /**
     * Returns the {@link ValueType} for the database product.
     *
     * @return the value type or null
     */
    public ValueType<?> getValueType();

}
