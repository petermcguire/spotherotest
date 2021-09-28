using System;
using System.Collections.Generic;

#nullable disable

namespace api_server.Models
{
    public partial class WorkedHour
    {
        public int UserId { get; set; }
        public DateTime Date { get; set; }
        public decimal Hours { get; set; }
        public DateTime CreatedAt { get; set; }

        public virtual User User { get; set; }
    }
}
