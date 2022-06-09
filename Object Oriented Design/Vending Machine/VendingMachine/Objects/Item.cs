namespace VendingMachineService.Objects
{
    public class Item
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }
        public ItemType Type { get; set; }

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
            if ((obj == null) || !this.GetType().Equals(obj.GetType()))
            {
                return false;
            }
            else
            {
                Item p = (Item)obj;
                return Name == p.Name;
            }
        }

        public override int GetHashCode()
        {
            return Name.GetHashCode();
        }
    }
}