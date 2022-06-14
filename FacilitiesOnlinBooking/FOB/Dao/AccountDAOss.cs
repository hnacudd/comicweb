using FacilitiesOnlinBooking.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Dao
{
    public class AccountDAOss:DAO
    {
        public Account GetAccount(int id)
        {
            Account account = new Account();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [account] WHERE Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        account = new Account
                       (
                            reader.GetInt32("Id"),
                            reader.GetString("email"),
                            reader.GetString("acc_password"),
                            reader.GetString("full_name"),
                            reader.GetInt32("acc_role")
                        );
                    }
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
            return account;
        }
    }
}
