using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Model
{
    public class Building
    {
        public Building()
        {
        }

        public Building(int id, string name)
        {
            Id = id;
            this.name = name;
        }

        public int Id { get; set; }
        public string name { get; set; }
    }
}
