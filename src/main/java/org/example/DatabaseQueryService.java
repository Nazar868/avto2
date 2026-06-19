package org.example;

import org.example.dto.MaxProjectCountClient;
import org.example.util.FileReaderUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient>
    findMaxProjectsClient() {

        List<MaxProjectCountClient> result =
                new ArrayList<>();

        try (
                Connection conn =
                        Database.getInstance()
                                .getConnection();

                Statement stmt =
                        conn.createStatement()
        ) {

            String sql =
                    FileReaderUtil.readFile(
                            "find_max_projects_client.sql"
                    );

            ResultSet rs =
                    stmt.executeQuery(sql);

            while (rs.next()) {

                result.add(
                        new MaxProjectCountClient(
                                rs.getString("name"),
                                rs.getInt("project_count")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
