using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Dao
{
    public class DAO
    {
            // Những đối tượng dùng chung
            internal SqlConnection connection = null;
            internal SqlCommand command = null;
            internal SqlDataReader reader = null;
            public string GetConnectionString()
            {
                IConfiguration config = new ConfigurationBuilder()
                    .SetBasePath(Directory.GetCurrentDirectory())
                    .AddJsonFile("appsettings.json", true, true)
                    .Build();
                return config["ConnectionStrings:fob"];
            }

            /*public int ExecuteQuery(Employee employee, SqlParameter[] param)
            {
                return 0;
            }*/
    }
}
