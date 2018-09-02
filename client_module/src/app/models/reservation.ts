export class reservation{
    public fromDate:string;
    public toDate:string;
    public price:string;
    public capacity:string;
    public accommodationId:number;
    public id:string;
    constructor(){
        this.fromDate ='';
        this.toDate='';
        this.price='';
        this.capacity='';
        this.accommodationId = 0;
        this.id='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}