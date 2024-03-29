package zodiac.builder.insert;

import zodiac.builder.ColumnValueProvider;
import zodiac.builder.preparer.DataPreparer;

public class InsertColumn implements ColumnValueProvider<InsertColumnValue> {

    private final InsertQuery insertQuery;
    private final DataPreparer preparer;

    InsertColumn(InsertQuery insertQuery) {
        this.insertQuery = insertQuery;
        preparer = insertQuery.getPreparer();
    }

    @Override
    public InsertColumnValue setString(String val) {
        insertQuery.addColumnValue(
                preparer.prepareString(val)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setInteger(Integer val) {
        insertQuery.addColumnValue(
                preparer.prepareInteger(val)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setLong(Long val) {
        insertQuery.addColumnValue(
                preparer.prepareLong(val)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setDouble(Double val, String formatPattern) {
        insertQuery.addColumnValue(
                preparer.prepareDouble(val, formatPattern)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setBoolean(Boolean condition, String trueReplacement, String falseReplacement) {
        insertQuery.addColumnValue(
                preparer.prepareBoolean(condition, trueReplacement, falseReplacement)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setDate(String val) {
        insertQuery.addColumnValue(
                preparer.prepareDate(val)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setTimestamp(Long val) {
        insertQuery.addColumnValue(
                preparer.prepareTimestamp(val)
        );
        return returnInsertColumnValue();
    }

    @Override
    public InsertColumnValue setRawString(String val) {
        insertQuery.addColumnValue(val);
        return returnInsertColumnValue();
    }

    private InsertColumnValue returnInsertColumnValue() {
        return insertQuery.getPool().getInsertColumnValue();
    }
}
