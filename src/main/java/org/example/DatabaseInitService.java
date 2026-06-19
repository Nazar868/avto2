package org.example;

import org.example.util.FileReaderUtil;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitService {

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
                            "init_db.sql"
                    );

            stmt.execute(sql);

            System.out.println("DB initialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
