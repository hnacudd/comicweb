using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Model
{
    public class Account
    {
        public Account()
        {
        }

        public Account(int id, string email, string passWord, string name, int role)
        {
            Id = id;
            this.email = email;
            this.passWord = passWord;
            this.name = name;
            this.role = role;
        }

        public int Id { get; set; }
        public string email { get; set; }
        public string passWord { get; set; }
        public string name { get; set; }
        public int role { get; set; }

    }
}
