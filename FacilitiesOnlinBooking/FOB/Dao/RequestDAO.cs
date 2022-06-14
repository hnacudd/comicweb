using FacilitiesOnlinBooking.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Dao
{
    public class RequestDAO:DAO
    {
        AccountDAOss AccountDAOss = new AccountDAOss();
        public List<Request> GetRequest()
        {
            List<Request> requests = new List<Request>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request]", connection);

            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new Request
                       (
                            reader.GetInt32("Id"),
                            AccountDAOss.GetAccount(reader.GetInt32("acc_Id")),
                            reader.GetString("note"),
                            reader.GetInt32("request_status"),
                            reader.GetDateTime("date_created")
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
        public List<Request> GetRequestByUser(int id)
        {
            List<Request> requests = new List<Request>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request] where acc_Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new Request
                       (
                            reader.GetInt32("Id"),
                            AccountDAOss.GetAccount(reader.GetInt32("acc_Id")),
                            reader.GetString("note"),
                            reader.GetInt32("request_status"),
                            reader.GetDateTime("date_created")
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
        public List<Request> GetPendingRequest()
        {
            List<Request> requests = new List<Request>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request] where request_status = 1", connection);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new Request
                       (
                            reader.GetInt32("Id"),
                            AccountDAOss.GetAccount(reader.GetInt32("acc_Id")),
                            reader.GetString("note"),
                            reader.GetInt32("request_status"),
                            reader.GetDateTime("date_created")
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
        public Request GetRequestDetail(int id)
        {
            Request requests = new Request();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request] WHERE Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests = new Request
                       (
                            reader.GetInt32("Id"),
                            AccountDAOss.GetAccount(reader.GetInt32("acc_Id")),
                            reader.GetString("note"),
                            reader.GetInt32("request_status"),
                            reader.GetDateTime("date_created")
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
            return requests;
        }
        internal int DeleteRequest(int id)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "DELETE FROM request WHERE Id = @cid";
            command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@cid", id);
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
        public int InsertRequest(Request request)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "INSERT INTO request VALUES(@acc,@note, @requeststatus, @date)";
            command = new SqlCommand(sql, connection);
            //command.Parameters.AddWithValue("@cid", employee.id);
            command.Parameters.AddWithValue("@acc", request.Account.Id);
            command.Parameters.AddWithValue("@note", request.note);
            command.Parameters.AddWithValue("@requeststatus", request.requestStatus);
            command.Parameters.AddWithValue("@date", request.DateCreated);

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

        internal int UpdateRequest(Request request)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "UPDATE request SET  acc_Id = @acc,note = @note, request_status =@requeststatus, date_created = @date WHERE Id = @cid";
            command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@acc", request.Account.Id);
            command.Parameters.AddWithValue("@note", request.note);
            command.Parameters.AddWithValue("@requeststatus", request.requestStatus);
            command.Parameters.AddWithValue("@date", request.DateCreated);
            command.Parameters.AddWithValue("@cid", request.Id);
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
    }
}
