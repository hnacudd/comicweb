using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Model
{
    public class Request
    {
        public Request()
        {
            
        }

        public Request(int id, Account account, string note, int requestStatus,DateTime Date_Created)
        {
            Id = id;
            Account = account;
            this.note = note;
            this.requestStatus = requestStatus;
            this.DateCreated = DateCreated;
        }

        public int Id { get; set; }
        public Account Account { get; set; }
        public string note { get; set; }
        public int requestStatus { get; set; }
        public DateTime DateCreated { get; set; }
    }
}
