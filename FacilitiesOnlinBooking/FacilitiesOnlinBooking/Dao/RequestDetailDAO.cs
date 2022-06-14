using FacilitiesOnlinBooking.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Dao
{
    public class RequestDetailDAO:DAO
    {
        RequestDAO requestDao = new RequestDAO();
        RoomDAOss RoomDAOss = new RoomDAOss();
        public List<RequestDetailcs> GetRequest()
        {
            List<RequestDetailcs> requests = new List<RequestDetailcs>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request_detail]", connection);

            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new RequestDetailcs
                       (
                            reader.GetInt32("Id"),
                            requestDao.GetRequestDetail(reader.GetInt32("request_Id")),
                            RoomDAOss.GetRoomDetail(reader.GetInt32("room_Id")),
                            reader.GetInt32("time_using"),
                            reader.GetDateTime("date_booked")
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
        public List<RequestDetailcs> GetRequestByRequestID(int Id)
        {
            List<RequestDetailcs> requests = new List<RequestDetailcs>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request_detail]where request_Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", Id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new RequestDetailcs
                       (
                            reader.GetInt32("Id"),
                            requestDao.GetRequestDetail(reader.GetInt32("request_Id")),
                            RoomDAOss.GetRoomDetail(reader.GetInt32("room_Id")),
                            reader.GetInt32("time_using"),
                            DateTime.Parse(reader.GetString("date_booked"))
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
        public RequestDetailcs GetRequestDetail(int id)
        {
            RequestDetailcs requestDetailcs = new RequestDetailcs();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [request_detail] WHERE Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requestDetailcs = new RequestDetailcs
                       (
                            reader.GetInt32("Id"),
                            requestDao.GetRequestDetail(reader.GetInt32("request_Id")),
                            RoomDAOss.GetRoomDetail(reader.GetInt32("room_Id")),
                            reader.GetInt32("time_using"),
                            reader.GetDateTime("date_booked")
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
        internal int DeleteRequest(int id)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "DELETE FROM request_detail WHERE Id = @cid";
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
        public int InsertRequestDetail(RequestDetailcs requestDetailcs)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "INSERT INTO request_detail VALUES(@request,@room, @time, @date)";
            command = new SqlCommand(sql, connection);
            //command.Parameters.AddWithValue("@cid", employee.id);
            command.Parameters.AddWithValue("@request", requestDetailcs.Request.Id);
            command.Parameters.AddWithValue("@room", requestDetailcs.Room.Id);
            command.Parameters.AddWithValue("@time", requestDetailcs.timeUsing);
            command.Parameters.AddWithValue("@date", requestDetailcs.date_Booked);

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

        internal int UpdateRequestDatail(RequestDetailcs requestDetailcs)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "UPDATE request_detail SET request_Id = @request,room_Id = @room, time_using =@time, date_booked = @date WHERE Id = @cid";
            command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@request", requestDetailcs.Request.Id);
            command.Parameters.AddWithValue("@room", requestDetailcs.Room.Id);
            command.Parameters.AddWithValue("@time", requestDetailcs.timeUsing);
            command.Parameters.AddWithValue("@date", requestDetailcs.date_Booked);
            command.Parameters.AddWithValue("@cid", requestDetailcs.Id);
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
