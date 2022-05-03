
**Raman Rapport - Networking**
Projekted började med att implementera Recycleview på **activity_main.xml**. Därefter sorterade jag min **list_item.xml**, där jag implementerade tre olika textview som fick unika IDs (namn,location,type).
Inom **list_item.xml** använde jag mig av linearlayout vertical. Därefter implementera jag ett MyAdapter class. 
Inom MyAdapter classen implemenera jag metoderna som kommer med RecyclerView.Adapter och MyViewHolder. Innan jag påbörjar skriva kod inom MyAdapter behöver jag sortera ut getters and setters för data som vi kommer hämta från JSON datan. 
I vårt fall är det tre olika getters and setters. Inom MyAdapter kallade vi superclassen MyViewHolder. Inom Classen har vi tre olika private datavariabler och connectade med **list_item.xml** de tre olika textview iderna, genom findviewby resource.
    
    ```
        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView name;
            private TextView type;
            private TextView location;
    
    
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                type = itemView.findViewById(R.id.type);
                location = itemView.findViewById(R.id.location);
            }
        }
    ```
Inom MyAdapter classen implementerade jag LayoutInflater som anpassar våran xml till contenten som skickas från Mountain JSON. 
Man kan säga att den blåser upp våran view holder och gör den synlig.

    ```
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }
    ```
onBindViewHolder positionerar våra dataVariabler från arraylisten och hämtar även från de olika getters som vi har i **Mountain**.

```
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.name.setText(mountain.get(position).getName());
        holder.location.setText(mountain.get(position).getLocation());
        holder.type.setText(mountain.get(position).getType());
    }
```





Bilder läggs i samma mapp som markdown-filen.

![](android.png)

