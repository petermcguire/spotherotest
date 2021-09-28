using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using api_server.Models;


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
        public ActionResult GetUsers() {
            return Ok(_context.Users.ToList());
        }
    }
}