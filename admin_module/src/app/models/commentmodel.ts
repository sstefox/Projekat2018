export class commentmodel{
    public id :string;
    public message:string;
    public user:string;
    public entryDate:string;
    public status:number;
    public accommodationTitle:string;
    constructor(){
        this.id = '';
        this.message='';
        this.user='';
        this.entryDate = '';
        this.status=0;
        this.accommodationTitle='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}