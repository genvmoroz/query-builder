package zodiac.builder.update;

import zodiac.builder.Builder;
import zodiac.builder.ColumnProvider;
import zodiac.builder.WhereClauseProvider;

import java.util.Objects;

public class UpdateColumnValue implements ColumnProvider<UpdateColumn>, WhereClauseProvider<UpdateWhereClause>, Builder {

    private final UpdateQuery updateQuery;

    UpdateColumnValue(UpdateQuery updateQuery) {
        this.updateQuery = updateQuery;
    }

    @Override
    public UpdateColumn column(String columnName) {
        if (Objects.isNull(columnName) || columnName.trim().isEmpty()) {
            throw new IllegalArgumentException("The column name cannot be null or empty");
        }
        updateQuery
                .append(", ")
                .append(columnName);

        return updateQuery
                .getPool()
                .getUpdateColumn();
    }

    @Override
    public UpdateWhereClause whereClause(String columnName) {
        if (Objects.isNull(columnName) || columnName.trim().isEmpty()) {
            throw new IllegalArgumentException("The column name cannot be null or empty");
        }
        if (updateQuery.isFirstWhereClause) {
            updateQuery
                    .append(" WHERE ")
                    .append(columnName);
            updateQuery.isFirstWhereClause = false;
        } else {
            updateQuery
                    .append(" ")
                    .append(columnName);
        }
        return updateQuery
                .getPool()
                .getUpdateWhereClause();
    }

    @Override
    public String build() {
        return updateQuery.getQuery();
    }
}
