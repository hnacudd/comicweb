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
            command = new SqlCommand("select * from [room] WHERE Id = @cid", connection);
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
                            reader.GetString("room_name")                          
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
        public List<Room> GetRoom()
        {
            BuildingDAO buildingDAO = new BuildingDAO();
            List<Room> lstRoom = new List<Room>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [room]", connection);

            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        lstRoom.Add(new Room
                       (
                            reader.GetInt32("Id"),
                            reader.GetString("room_name"),
                            buildingDAO.GetBuildingDetail(reader.GetInt32("building_id"))
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
            return lstRoom;
        }
        public List<Room> GetRoomByBuilding(int Id)
        {
            BuildingDAO buildingDAO = new BuildingDAO();
            List<Room> lstRoom = new List<Room>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [room] where building_Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", Id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        lstRoom.Add(new Room
                       (
                            reader.GetInt32("Id"),
                            reader.GetString("room_name"),
                            buildingDAO.GetBuildingDetail(reader.GetInt32("building_id"))
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
            return lstRoom;
        }
    }
}
