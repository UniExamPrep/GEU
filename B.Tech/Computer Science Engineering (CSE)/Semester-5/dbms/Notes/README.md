Run order:
1. Run db_schema.sql to create the database and tables.
2. Run db_data.sql to populate sample data and demonstrate transactions.
3. Run db_users.sql to create the lab user and apply privileges.
4. Run db_triggers.sql to create triggers and audit logging.
5. Run db_queries.sql to execute the SELECT/ALTER/DELETE/DROP operations.

Example command:

```bash
mysql -u root -p < "db_schema.sql"
mysql -u root -p < "db_data.sql"
mysql -u root -p < "db_users.sql"
mysql -u root -p < "db_triggers.sql"
mysql -u root -p < "db_queries.sql"
```

All SQL files are idempotent where practical and contain no comments so they are suitable for submission.# DBMS-LAB
