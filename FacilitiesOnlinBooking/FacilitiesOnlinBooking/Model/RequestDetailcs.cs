using FacilitiesOnlinBooking.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Model
{
    public class RequestDetailcs
    {
        public RequestDetailcs(int id, Request request, Room room, int timeUsing, DateTime date_Booked)
        {
            Id = id;
            Request = request;
            Room = room;
            this.timeUsing = timeUsing;
            this.date_Booked = date_Booked;
        }
        public RequestDetailcs()
        {
            
        }
        public int Id { get; set; }
        public Request Request { get; set; }
        public Room Room { get; set; }
        public int timeUsing { get; set; }
        public DateTime date_Booked { get; set; }
    }
}
