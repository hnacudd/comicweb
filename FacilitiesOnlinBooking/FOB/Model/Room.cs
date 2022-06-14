using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Model
{
    public class Room
    {
        public Room(int id, string name)
        {
            Id = id;
            this.name = name;
        }
        public Room()
        {
           
        }
        public int Id { get; set; }
        public string name { get; set; }
        public Building Building { get; set; } 
    }
}
