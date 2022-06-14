using FacilitiesOnlinBooking.Dao;
using FacilitiesOnlinBooking.Model;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace FacilitiesOnlinBooking.Controller
{
    public class RequestDetailController : Microsoft.AspNetCore.Mvc.Controller
    {
        public IActionResult GetList(int Id)
        {
            RequestDetailDAO dao = new RequestDetailDAO();
            List<RequestDetailcs> lstRequest = dao.GetRequestByRequestID(Id);
            return View(lstRequest);
        }
    }
}
