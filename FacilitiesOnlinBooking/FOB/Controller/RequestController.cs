using FacilitiesOnlinBooking.Dao;
using FacilitiesOnlinBooking.Model;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Controller
{
    public class RequestController : Microsoft.AspNetCore.Mvc.Controller
    {
        public IActionResult GetListRequest()
        {
            RequestDAO dao = new RequestDAO();
            List<Request> lstRequest = new List<Request>();
            lstRequest = dao.GetRequest();
            ViewData["listRequest"] = lstRequest;
            return View(lstRequest);
        }
        public IActionResult GetRequestDetail(int id)
        {
            RequestDAO dao = new RequestDAO();
            Request request = new Request();
            request = dao.GetRequestDetail(id);
            ViewData["request"] = request;
            return View(request);
        }
        public IActionResult CreateRequest()
        {
            return View();
        }
        [HttpPost]
        public IActionResult CreateRequest([Bind] Request request)
        {
            RequestDAO dao = new RequestDAO();
            dao.InsertRequest(request);
            return View("GetListRequest");
        }
        public IActionResult EditRequest()
        {
            return View();
        }
    }
}
