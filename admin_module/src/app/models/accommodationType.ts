export class accommodationType{
    public id :string;
    public accommodationTypeName :string;
    constructor(){
        this.id = '';
        this.accommodationTypeName = '';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}