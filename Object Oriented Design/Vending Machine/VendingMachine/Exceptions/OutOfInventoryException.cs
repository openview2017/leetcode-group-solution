using System;

namespace VendingMachineService.Exceptions
{
    public class OutOfInventoryException : Exception
    {
        public OutOfInventoryException()
        {
        }

        public OutOfInventoryException(string message) : base(message)
        {
        }

        public OutOfInventoryException(string message, Exception inner) : base(message, inner)
        {
        }
    }
}
