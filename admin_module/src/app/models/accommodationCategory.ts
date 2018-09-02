export class accommodationCategory{
    public id :string;
    public accommodationCategoryName :string;
    constructor(){
        this.id = '';
        this.accommodationCategoryName = '';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}