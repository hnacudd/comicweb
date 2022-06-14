using FacilitiesOnlinBooking.Dao;
using FacilitiesOnlinBooking.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FacilitiesOnlinBooking.Controller
{
    public class HomeController : Microsoft.AspNetCore.Mvc.Controller
    {
        // GET: HomeController
        // GET: HomeController
        public ActionResult Index()
        {
            String Id = HttpContext.Session.GetString("AccountId");
            ViewBag.AccountId = Id;
            return View();
        }

        public ActionResult Login()
        {
            ViewBag.mess1 = HttpContext.Session.GetString("mes1");
            return View();
        }

        public ActionResult UpdateAccount()
        {
            string id = HttpContext.Request.Query["id"].ToString();
            AccountDAOss d = new AccountDAOss();
            Account c = d.GetAccountById(id);
            ViewBag.mess2 = HttpContext.Session.GetString("mes2");
            return View(c);
        }

        public ActionResult PhanQuyen()
        {
            string id = HttpContext.Request.Query["id"].ToString();
            AccountDAOss d = new AccountDAOss();
            Account c = d.GetAccountById(id);
            ViewBag.mess4 = HttpContext.Session.GetString("mes5");
            return View(c);
        }

        public ActionResult Register()
        {

            ViewBag.mess = HttpContext.Session.GetString("mes");
            return View();
        }

        [HttpPost]
        public ActionResult RegisterAccount()
        {
            AccountDAOss d = new AccountDAOss();
            string pass = HttpContext.Request.Form["psw1"];
            string name = HttpContext.Request.Form["name1"];
            string repass = HttpContext.Request.Form["psw-repeat1"];
            string email = HttpContext.Request.Form["email1"];
            if (!pass.Trim().Equals(repass.Trim()))
            {
                HttpContext.Session.SetString("mes", "Xác nhận mật khẩu sai vui lòng nhập lại");
            }
            else if (email.Trim().Equals("") || pass.Trim().Equals("") || name.Trim().Equals("") || repass.Trim().Equals(""))
            {
                HttpContext.Session.SetString("mes", "Vui lòng điền đầy đủ thông tin đăng ký tài khoản");
            }
            else if (d.CheckAccountExist(email).Id > 0)
            {
                HttpContext.Session.SetString("mes", "Email này đã được đăng ký tài khoản");
            }
            else
            {
                Account c = new Account();
                c.name = name;
                c.passWord = pass;
                c.role = 2;
                c.email = email;
                if (d.RegisterAccount(c) > 0)
                {
                    HttpContext.Session.SetString("mes", "Đăng ký thành công !");
                }
                else
                {
                    HttpContext.Session.SetString("mes", "Đăng ký thất bại !");
                }
            }
            return Redirect("/Home/Register");
        }

        [HttpPost]
        public ActionResult LoginAccount()
        {
            AccountDAOss d = new AccountDAOss();
            string name = HttpContext.Request.Form["username"];
            string pass = HttpContext.Request.Form["password"];

            if (name.Trim().Equals("") || pass.Trim().Equals(""))
            {
                HttpContext.Session.SetString("mes1", "Vui lòng điền đầy đủ tài khoản mật khẩu đăng nhập");
                return Redirect("/Home/Login");
            }
            else
            {
                Account a = d.CheckAccount(name, pass);
                if (a.Id > 0)
                {
                    HttpContext.Session.SetString("AccountId", a.Id.ToString());
                    if(a.role == 2) { return Redirect("/Request/GetListRequest"); }
                    else { return Redirect("/Request/GetListRequestStaff"); }
                }
                else
                {
                    HttpContext.Session.SetString("mes1", "Sai tài khoản hoặc mật khẩu");
                    return Redirect("/Home/Login");
                }
            }

        }

        [HttpPost]
        public ActionResult ChangePass()
        {
            AccountDAOss d = new AccountDAOss();
            string id = HttpContext.Request.Form["idAccount"];
            string oldpass = HttpContext.Request.Form["oldpass"];
            string pass = HttpContext.Request.Form["psw1"];
            string name = HttpContext.Request.Form["name1"];
            string repass = HttpContext.Request.Form["psw-repeat1"];
            string email = HttpContext.Request.Form["email1"];
            if (!pass.Trim().Equals(repass.Trim()))
            {
                HttpContext.Session.SetString("mes2", "Xác nhận mật khẩu sai vui lòng nhập lại");
            }
            else if (email.Trim().Equals("") || pass.Trim().Equals("") || name.Trim().Equals("") || repass.Trim().Equals(""))
            {
                HttpContext.Session.SetString("mes2", "Vui lòng điền đầy đủ thông tin đăng ký tài khoản");
            }
            else if (d.CheckAccount(email, oldpass).Id == 0)
            {
                HttpContext.Session.SetString("mes2", "Mật khẩu cũ bị sai kiểm tra lại");
            }
            else
            {
                Account c = new Account();
                c.name = name;
                c.passWord = pass;
                c.Id = Convert.ToInt32(id);
                if (d.UpdateAccount(c) > 0)
                {
                    HttpContext.Session.SetString("mes2", "Thay đổi thông tin thành công!");
                }
                else
                {
                    HttpContext.Session.SetString("mes2", "Thay đổi thông tin thất bại !");
                }
            }
            return Redirect("/Home/UpdateAccount?id=" + id);
        }


        [HttpPost]
        public ActionResult PhanquyenAccount()
        {
            AccountDAOss d = new AccountDAOss();
            string id = HttpContext.Request.Form["idAccount"];

            string quyen = HttpContext.Request.Form["chucvu"];
            if (quyen.Trim().Equals("") || quyen.Equals("0"))
            {
                HttpContext.Session.SetString("mes5", "Vui lòng chọn chức vụ");
            }
            else
            {
                Account c = new Account();
                c.role = Convert.ToInt32(quyen);
                c.Id = Convert.ToInt32(id);
                if (d.phanQuyen(c) > 0)
                {
                    HttpContext.Session.SetString("mes5", "Thay đổi quyền thành công!");
                }
                else
                {
                    HttpContext.Session.SetString("mes5", "Thay đổi quyền thất bại !");
                }
            }
            return Redirect("/Home/PhanQuyen?id=" + id);
        }

        [HttpPost]
        public ActionResult DeleteAccount()
        {
            AccountDAOss d = new AccountDAOss();
            string id = HttpContext.Request.Form["id"];

            if (d.DeleteAc(id) > 0)
            {
                HttpContext.Session.SetString("mes3", "Xóa tài khoản thành công");
            }
            else
            {
                HttpContext.Session.SetString("mes3", "Xóa tài khoản thất bại !");
            }
            return Redirect("/Home/ManagerAccount");
        }


        public ActionResult ManagerAccount()
        {
            ViewBag.mess3 = HttpContext.Session.GetString("mes3");
            AccountDAOss d = new AccountDAOss();
            String Id = HttpContext.Session.GetString("AccountId");
            Account c = d.GetAccountById(Id);
            ViewBag.role = c.role;
            ViewBag.listAccount = d.GetListAccount();
            return View();
        }

        // GET: HomeController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: HomeController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: HomeController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: HomeController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: HomeController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: HomeController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: HomeController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
