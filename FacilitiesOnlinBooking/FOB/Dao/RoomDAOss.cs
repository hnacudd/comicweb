using FacilitiesOnlinBooking.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Dao
{
    public class RoomDAOss:DAO
    {
        public Room GetRoomDetail(int id)
        {
            Room room = new Room();
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
                        room = new Room
                       (
                            reader.GetInt32("Id"),
                            reader.GetString("name")                          
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
            return room;
        }
    }
}
