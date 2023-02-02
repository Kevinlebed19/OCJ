package com.kevin;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        var databaseURL = "jdbc:h2:mem:";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {

            String sql = "select * from INFORMATION_SCHEMA.TABLES";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    System.out.println(resultSet.getString(1));
                }
            }
            try (Statement statement = connection.createStatement()) {

                final var createTableZebra = "create table ZEBRA(FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(75))";

                executeUpdate(statement, createTableZebra);

                final var insertZebraStan = "insert into ZEBRA values('Stan', 'Zebulon')";
                final var insertZebraFran = "insert into ZEBRA values('Fran', 'The WOman')";
                final var insertZebraDan = "insert into ZEBRA values('Dan', 'The Tan Man')";

                executeUpdate(statement, insertZebraStan);
                executeUpdate(statement, insertZebraFran);

                final var selectStarFromZebra = "select * from ZEBRA";

                executeQuery(connection, selectStarFromZebra);

                execute(connection, insertZebraDan);
                execute(connection, selectStarFromZebra + " where FIRST_NAME = 'Stan'");

                doItWithBindVariables(connection);

                System.out.println("callable statements");
                doItWithCallableStatements(connection);
            }
        }
    }

    private static void executeUpdate(Statement statement, String sql) throws SQLException {
        var rows = statement.executeUpdate(sql);

        System.out.print("rows: ");
        System.out.println(rows);
    }

    private static void executeQuery(Connection connection, String sql) throws SQLException {

        try (var preparedStatement = connection.prepareStatement(sql)) {

            try (var resultSet = preparedStatement.executeQuery()) {

                printResultSet(resultSet);
            }
        }
    }

    private static void execute(Connection connection, String sql) throws SQLException {

        try (var preparedStatement = connection.prepareStatement(sql)) {

            var isResultSet = preparedStatement.execute();

            if (isResultSet) {

                try (var resultSet = preparedStatement.getResultSet();) {

                    printResultSet(resultSet);
                }
            } else {
                var updateCount = preparedStatement.getUpdateCount();

                System.out.println("Update count: " + updateCount);
            }
        }
    }

    private static void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(metaData.getColumnName(i) + ": " + resultSet.getObject(i));
            }
        }
    }

    private static void doItWithBindVariables(Connection connection) throws SQLException {

        final var sql = "insert into ZEBRA values(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "Pam");
            preparedStatement.setString(2, "Zabulous");

            var rows = preparedStatement.executeUpdate();

            System.out.println("rows: " + rows);

            preparedStatement.setString(1, "Zetus");
            preparedStatement.setString(2, "ZamBam");

            rows = preparedStatement.executeUpdate();

            System.out.println("rows: " + rows);
        }
    }

    private static void doItWithCallableStatements(Connection connection) throws SQLException {

        final var sql = "{? = call abs(?)}";

        try (CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setInt(2, -5);
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
        }
    }
}
