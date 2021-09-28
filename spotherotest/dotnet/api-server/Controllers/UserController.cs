using System.Collections.Generic;
using System;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using api_server.Models;
using Microsoft.EntityFrameworkCore;

namespace api_server.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UserController : ControllerBase
    {
        private DataContext _context = null;
        public UserController(DataContext context)
        {
            _context = context;
        }

        [HttpGet]
        public ActionResult GetUsers([FromQuery]string active) {
            List<User> result = new List<User>();
            if (active is null) {
                result = _context.Users.ToList();
            } else {
                result = _context.Users.Where(u => u.Active == (active == "true" ? true : false)).ToList();
            }

            return Ok(result);
        }
        [HttpGet("{Id}")]
        public ActionResult GetUser(int Id) {
            return Ok(_context.Users.Where(u => u.Id == Id));
        }
        [HttpGet("{Id}/worked_hours")]
        public ActionResult GetUserWorkedHours(int Id) {
            return Ok(_context.WorkedHours.Where(wh => wh.UserId == Id).ToList());
        }
        [HttpPost("{Id}/worked_hours")]
        public ActionResult<WorkedHour> PostUserWorkedHours(int Id, WorkedHour wh) {
            wh.UserId = Id;
            _context.Add(wh);
            _context.SaveChanges();
            return Ok(wh);
        }
    }
}