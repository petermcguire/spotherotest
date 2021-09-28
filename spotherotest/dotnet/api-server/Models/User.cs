using System;
using System.Collections.Generic;

#nullable disable

namespace api_server.Models
{
    public partial class User
    {
        public User()
        {
            WorkedHours = new HashSet<WorkedHour>();
        }

        public int Id { get; set; }
        public int? ManagerId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
        public bool? Active { get; set; }
        public DateTime CreatedAt { get; set; }

        public virtual ICollection<WorkedHour> WorkedHours { get; set; }
    }
}
