using FacilitiesOnlinBooking.Dao;
using FacilitiesOnlinBooking.Model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;

namespace FacilitiesOnlinBooking.Controller
{
    public class RequestController : Microsoft.AspNetCore.Mvc.Controller
    {

        public IActionResult GetListRequest()
        {
            RequestDAO dao = new RequestDAO();
            string Id = HttpContext.Session.GetString("AccountId");
            List<Request> lstRequest = new List<Request>();
            lstRequest = dao.GetRequestByUser(Convert.ToInt32(Id));
            ViewData["listRequest"] = lstRequest;
            return View(lstRequest);
        }
        public IActionResult GetListApprovedRequest()
        {
            RequestDAO dao = new RequestDAO();
            List<Request> lstRequest = new List<Request>();
            lstRequest = dao.GetApprovedRequest();
            return View(lstRequest);
        }
        public IActionResult GetListRequestStaff()
        {
            RequestDAO dao = new RequestDAO();
            List<Request> lstRequest = new List<Request>();
            lstRequest = dao.GetPendingRequest();
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
            BuildingDAO buildingDAO = new BuildingDAO();
            RoomDAOss roomDAOss = new RoomDAOss();
            dynamic mymodel = new ExpandoObject();
            mymodel.Building = buildingDAO.GetBuilding();
            mymodel.Room = roomDAOss.GetRoom();
            return View(mymodel);
        }
        [HttpPost]
        public IActionResult CreateRequest([Bind] Request request)
        {
            int slot = Convert.ToInt32(HttpContext.Request.Form["Slot"]);
            int room_Id =  Convert.ToInt32(HttpContext.Request.Form["Room"]);
            DateTime date = DateTime.Parse(HttpContext.Request.Form["birthdaytime"]);
            string note = HttpContext.Request.Form["Note"];
            string Id = HttpContext.Session.GetString("AccountId"); 
            AccountDAOss accDao = new AccountDAOss();
            request.Account = accDao.GetAccountById(Id);
            request.DateCreated = DateTime.Now;
            request.note = note;
            request.requestStatus = 1;
            RequestDAO dao = new RequestDAO();
            RequestDetailcs requestDetailcs = new RequestDetailcs();
            RequestDetailDAO requestDetailDAO = new RequestDetailDAO();
            RoomDAOss roomDao = new RoomDAOss();
            dao.InsertRequest(request);
            requestDetailcs.Request = dao.GetRequestDetailMax();
            requestDetailcs.Room = roomDao.GetRoomDetail(Convert.ToInt32(room_Id));
            requestDetailcs.timeUsing = slot;
            requestDetailcs.date_Booked = date;
            requestDetailDAO.InsertRequestDetail(requestDetailcs);
            return Redirect("GetListRequest");
        }
        public IActionResult EditRequestAccept([Bind] Request request)
        {
            RequestDAO dao = new RequestDAO();
            dao.UpdateRequestAccept(request);
            return Redirect("GetListRequestStaff");
        }
        public IActionResult EditRequestDenied([Bind] Request request)
        {
            RequestDAO dao = new RequestDAO();
            dao.UpdateRequestStatusDenied(request);
            return Redirect("GetListRequestStaff");
        }
        [HttpPost]
        public IActionResult DeleteRequest()
        {
            string id = HttpContext.Request.Form["id"];
            RequestDetailDAO rdDao = new RequestDetailDAO();
            RequestDAO dao = new RequestDAO();
            List<RequestDetailcs> requestDetailcs =  rdDao.GetRequestByRequestID(Convert.ToInt32(id));
            foreach(RequestDetailcs request in requestDetailcs)
            {
                rdDao.DeleteRequest(request.Id);
            }
            dao.DeleteRequest(Convert.ToInt32(id));
            return Redirect("GetListRequest");
        }
    }
}
