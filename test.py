def truncate_table(conn, table_name):
    """
    Truncate the table data.
    """
    try:
        cursor = conn.cursor()
        cursor.execute(f"TRUNCATE TABLE {table_name}")
        conn.commit()
        print(f"Table {table_name} truncated successfully.")
    except Exception as e:
        logger.info(f"Error occurred while truncating table {table_name}: {e}")

def load_data_from_csv(conn, csv_file_path, table_name):
    """
    Load data from a CSV file into the specified table.
    """
    try:
        # Read data from CSV into DataFrame
        df = pd.read_csv(csv_file_path)
        
        # Convert DataFrame to list of tuples for insertion
        data_tuples = list(df.itertuples(index=False, name=None))
        
        # Generate placeholders for each tuple
        placeholders = ', '.join(['?' for _ in range(len(df.columns))])
        
        # Create SQL query for insertion
        sql_query = f"INSERT INTO {table_name} ({', '.join(df.columns)}) VALUES ({placeholders})"
        
        # Execute the insertion
        cursor = conn.cursor()
        cursor.executemany(sql_query, data_tuples)
        conn.commit()
        print(f"Data loaded successfully into {table_name}.")
    except Exception as e:
        logger.info(f"Error occurred while loading data into {table_name}: {e}")
def main():
    conn = mysql_connector(DEV_get_creds())
    if conn is None:
        return

    csv_file_path = 'path_to_your_csv_file.csv'  # Update the path to your CSV file
    table_name = 'T_BKGS_WRKSHEET_VW_RPT'        # Set the table name you want to work with

    # Truncate the table before loading new data
    truncate_table(conn, table_name)

    # Load data from CSV into the table
    load_data_from_csv(conn, csv_file_path, table_name)

    db_close(conn, db_name='your_db_name')  # Update with your actual db name

if __name__ == "__main__":
    sess_log = "C:\\github\\sess_logs\\TableauReports\\data_migration.log"
    setup_logger(f"{sess_log}")
    logger = logging.getLogger(__name__)
    logger.info('>>>>>>>START PROCESS>>>>>>>')
    main()
def build_bookings_report(self, last_published_date_string):
    try:
        df = pd.read_csv(self.report_csv_path)
        df['rec_eff_dt'] = last_published_date_string  # Assuming you already added this line.

        # Write DataFrame to CSV (already existing code)
        df.to_csv(self.tableau_report, index=False)

        # Connect to the database (you may need to create this method or adjust as per your connection method)
        conn = mysql_connector(DEV_get_creds())
        
        # Truncate the existing table if needed
        truncate_table(conn, 'T_BKGS_WRKSHEET_VW_RPT')  # Ensure the function and table name are correct
        
        # Insert data into the database
        load_data_from_dataframe(conn, df, 'T_BKGS_WRKSHEET_VW_RPT')  # Ensure the function and table name are correct
        
        # Close the database connection (you may need to create this method or adjust as per your closing method)
        db_close(conn)

        logging.info("Completed Bookings Report Process!")
    except Exception as e:
        logging.error(f'Unable to complete the bookings report process. Got exception: {e}')

def truncate_table(conn, table_name):
    cursor = conn.cursor()
    cursor.execute(f"TRUNCATE TABLE {table_name}")
    conn.commit()
    logging.info(f"Table {table_name} truncated successfully.")

def load_data_from_dataframe(conn, df, table_name):
    # Assuming that the DataFrame column names match the table schema
    placeholders = ', '.join(['%s'] * len(df.columns))
    columns = ', '.join(df.columns)
    sql = f"INSERT INTO {table_name} ({columns}) VALUES ({placeholders})"
    data = [tuple(row) for row in df.values]
    
    cursor = conn.cursor()
    cursor.executemany(sql, data)
    conn.commit()
    logging.info(f"Data inserted into {table_name} successfully.")
