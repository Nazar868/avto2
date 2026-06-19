package org.example;

import org.example.util.FileReaderUtil;

import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {

        try (
                Connection conn =
                        Database.getInstance()
                                .getConnection();

                Statement stmt =
                        conn.createStatement()
        ) {

            String sql =
                    FileReaderUtil.readFile(
                            "populate_db.sql"
                    );

            stmt.execute(sql);

            System.out.println("DB populated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
