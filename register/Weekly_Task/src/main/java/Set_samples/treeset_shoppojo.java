package Set_samples;

public class treeset_shoppojo implements Comparable<treeset_shoppojo> {
    /*
    tree set sort in ascending order
     */
        private String product_name;
        private int Count;

    public String getproduct_name() {
            return product_name;
        }

        public void setproduct_name(String name) {
            this.product_name = name;
        }

        public int getCount() {
            return Count;
        }

        public void setCount(int Count) {
            this.Count = Count;
        }

        @Override
        public int compareTo(treeset_shoppojo o) {
           // return this.product_name.compareToIgnoreCase(s.getproduct_name());
            return Integer.compare(this.Count,o.getCount());
        }

}
