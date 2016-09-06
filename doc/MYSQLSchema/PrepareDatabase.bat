@echo off
"BuildSQL.bat"
mysql -u root -p policydb < PMSQL.sql
pause
echo Exit from MYSQL...