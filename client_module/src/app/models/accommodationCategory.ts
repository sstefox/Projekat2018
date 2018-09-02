export class accommodationCategory{
    public id :string;
    public categoryName :string;
    constructor(){
        this.id = '';
        this.categoryName = '';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}