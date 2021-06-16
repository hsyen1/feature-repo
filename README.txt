1. This project uses H2 in-memory database to perform CRUD operations.

2. Upon application start up, 3 tables will be created which are:
    a. USER - to store user related details
    b. FEATURE - to maintain a list of feature availables
    c. USER_FEATURE_ACCESS - relationship table between USER and FEATURE

3. Mock data will be inserted into each tables as well.

4. To add new user, just insert a row into the USER table.

    for e.g., INSERT INTO USER (id, email, name, created_date) VALUES (1, 'john@testing.com', 'John Doe', sysdate());

5. To add a new feature, insert a row into the FEATURE table.

    for e.g., INSERT INTO FEATURE (id, feature_code, feature_name) VALUES (4, 'DOWNLOAD_TXN_HISTORY', 'Download Transaction History');

6. A sample postman script can be found in the project folder (scripts.postman_collection.json)