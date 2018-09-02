export class reservation{
    public fromDate:string;
    public toDate:string;
    public capacity:number;
    public price:string;
    public username:string;
    public accommodationId:string;
    public id:string;
    constructor(){
        this.fromDate ='';
        this.toDate='';
        this.capacity=0;
        this.price='';
        this.username='';
        this.accommodationId='';
        this.id='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}