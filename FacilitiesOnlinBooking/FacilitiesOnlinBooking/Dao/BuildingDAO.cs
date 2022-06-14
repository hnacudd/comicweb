using FacilitiesOnlinBooking.Model;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Dao
{
    public class BuildingDAO:DAO
    {
        public List<Building> GetBuilding()
        {
            List<Building> requests = new List<Building>();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [building]", connection);

            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        requests.Add(new Building
                       (
                            reader.GetInt32("Id"),
                            reader.GetString("building_name")
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
        public Building GetBuildingDetail(int id)
        {
            Building building = new Building();
            connection = new SqlConnection(GetConnectionString());
            command = new SqlCommand("select * from [building] WHERE Id = @cid", connection);
            command.Parameters.AddWithValue("@cid", id);
            try
            {
                connection.Open();
                reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows == true)
                {
                    while (reader.Read())
                    {
                        building = new Building
                       (
                            reader.GetInt32("Id"),                            
                            reader.GetString("building_name")
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
            return building;

        }
        public int DeleteBuilding(int id)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "DELETE FROM dbo.building WHERE Id = @cid";
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

        // Insert building
        public int InsertBuilding(Building building)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "INSERT INTO dbo.building VALUES(@name)";
            command = new SqlCommand(sql, connection);
            //command.Parameters.AddWithValue("@cid", employee.id);
            command.Parameters.AddWithValue("@name", building.name);
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

        // Update building
        public int UpdateBuilding(Building building)
        {
            int numRow = 0;
            connection = new SqlConnection(GetConnectionString());
            string sql = "UPDATE dbo.building SET building_name = '" + building.name + "' WHERE Id = " + building.Id.ToString();
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
    }
}
