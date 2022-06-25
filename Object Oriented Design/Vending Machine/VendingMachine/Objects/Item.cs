namespace VendingMachineService.Objects
{
    public class Item
    {
        public string Id { get; }
        public string Name { get; }
        public decimal Price { get; }
        public ItemType Type { get; }

        public Item(string name, string id="001", decimal price = 0, ItemType type = ItemType.DEFAULT)
        {
            Id = id;
            Name = name;
            Price = price;
            Type = type;
        }

        public override bool Equals(object obj)
        {
            //Check for null and compare run-time types.
            if ((obj == null) || this.GetType() != obj.GetType())
            {
                return false;
            }
            else
            {
                var p = (Item)obj;
                return Name == p.Name;
            }
        }

        public override int GetHashCode()
        {
            return Name.GetHashCode();
        }
    }
}