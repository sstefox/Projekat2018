export class search{
    public fromDate:string;
    public toDate:string;
    public capacity:number;
    public location:string;
    public type:number;
    public serviceList:string[];
    public category:string;
    constructor(){
        this.fromDate='';
        this.toDate='';
        this.capacity=0;
        this.location='';
        this.type=0;
        this.serviceList=[];
        this.category='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}