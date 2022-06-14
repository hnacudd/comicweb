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

        public int RegisterAccount(Account account)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "INSERT INTO account VALUES(@em,@pass, @name, @rol)";
            command = new SqlCommand(sql, connection);
            //command.Parameters.AddWithValue("@cid", employee.id);
            command.Parameters.AddWithValue("@em", account.email);
            command.Parameters.AddWithValue("@pass", account.passWord);
            command.Parameters.AddWithValue("@name", account.name);
            command.Parameters.AddWithValue("@rol", account.role);
            try
            {
                connection.Open();
                numRow = command.ExecuteNonQuery(); // insert, update, delete
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
            return numRow;
        }

        public int UpdateAccount(Account account)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "UPDATE account SET acc_password = '" + account.passWord + "', full_name= '" + account.name + "' WHERE Id = " + account.Id.ToString();
            command = new SqlCommand(sql, connection);
            try
            {
                connection.Open();
                numRow = command.ExecuteNonQuery(); // insert, update, delete
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
            return numRow;
        }

        public int phanQuyen(Account account)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "UPDATE account SET acc_role = " + account.role + " WHERE Id = " + account.Id.ToString();
            command = new SqlCommand(sql, connection);
            try
            {
                connection.Open();
                numRow = command.ExecuteNonQuery(); // insert, update, delete
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
            return numRow;
        }

        public int DeleteAc(string id)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "DElete account WHERE Id = " + id.ToString();
            command = new SqlCommand(sql, connection);
            try
            {
                connection.Open();
                numRow = command.ExecuteNonQuery(); // insert, update, delete
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
            return numRow;
        }

        public Account CheckAccount(string name, string pass)
        {
            Account requestDetailcs = new Account();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [Account] WHERE email = @name and acc_password= @pass ", connection);
            command.Parameters.AddWithValue("@name", name);
            command.Parameters.AddWithValue("@pass", pass);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requestDetailcs = new Account
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
            return requestDetailcs;
        }

        public Account CheckAccountExist(string name)
        {
            Account requestDetailcs = new Account();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [Account] WHERE email = @name", connection);
            command.Parameters.AddWithValue("@name", name);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requestDetailcs = new Account
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
            return requestDetailcs;
        }

        public Account GetAccountById(string id)
        {
            Account requestDetailcs = new Account();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [Account] WHERE Id = " + id, connection);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requestDetailcs = new Account
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
            return requestDetailcs;
        }

        public List<Account> GetListAccount()
        {
            List<Account> requests = new List<Account>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [Account]", connection);

            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new Account
                       (
                            reader.GetInt32("Id"),
                            reader.GetString("email"),
                            reader.GetString("acc_password"),
                            reader.GetString("full_name"),
                            reader.GetInt32("acc_role")
                        ));
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
            return requests;
        }
    }
}
