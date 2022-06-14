using FacilitiesOnlinBooking.Dao;
using FacilitiesOnlinBooking.Model;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Controller
{
    public class BuildingController : Microsoft.AspNetCore.Mvc.Controller
    {
        public IActionResult ListBuilding()
        {
            BuildingDAO dao = new BuildingDAO();
            List<Building> listBuilding = new List<Building>();
            listBuilding = dao.GetBuilding();
            ViewData["listBuilding"] = listBuilding;
            return View(listBuilding);
        }

        public IActionResult AddBuilding()
        {
            return View();
        }
        [HttpPost]
        public IActionResult AddBuilding([Bind] Building building)
        {
            BuildingDAO dao = new BuildingDAO();
            dao.InsertBuilding(building);
            return View("ListBuilding");
        }
        public IActionResult UpdateBuilding(int id)
        {

            BuildingDAO dao = new BuildingDAO();
            dao.GetBuildingDetail(id);
            return View();
        }
        [HttpPost]
        public IActionResult UpdateBuilding([Bind] Building building)
        {
            BuildingDAO dao = new BuildingDAO();
            dao.UpdateBuilding(building);
            return View("ListBuilding");
        }
        [HttpPost]
        public IActionResult DeleteBuilding()
        {
            string id = HttpContext.Request.Form["id"];
            BuildingDAO dao = new BuildingDAO();
            dao.DeleteBuilding(Convert.ToInt32(id));
            return View("ListBuilding");
        }
    }
}
