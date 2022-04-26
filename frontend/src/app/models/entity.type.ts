export interface Entity {
    id: number;
    version: number;
    createdAt: Date;
    updatedAt: Date;
    draft: boolean;
}