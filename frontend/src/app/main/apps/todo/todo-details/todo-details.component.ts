import { Component, OnDestroy, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, takeUntil } from 'rxjs/operators';

import { FuseUtils } from '@fuse/utils';
import { fuseAnimations } from '@fuse/animations';

import { Todo } from 'app/main/apps/todo/todo.model';
import { TodoService } from 'app/main/apps/todo/todo.service';
import { Task } from "../../../../models/task.types";
import {TaskService} from "../../../../services/task.service";

@Component({
    selector     : 'todo-details',
    templateUrl  : './todo-details.component.html',
    styleUrls    : ['./todo-details.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations   : fuseAnimations
})
export class TodoDetailsComponent implements OnInit, OnDestroy
{
    todo: Task;
    tags: any[];
    formType: string;
    todoForm: FormGroup;
    done: boolean = false;

    @ViewChild('titleInput', {static: false})
    titleInputField;

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {TodoService} _todoService
     * @param {FormBuilder} _formBuilder
     */
    constructor(
        private _todoService: TodoService,
        private _formBuilder: FormBuilder,
        private taskService: TaskService
    )
    {
        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
        // Subscribe to update the current todo
        this._todoService.onCurrentTodoChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(([todo, formType]) => {

                if ( todo && formType === 'edit' )
                {
                    this.formType = 'edit';
                    this.todo = todo;
                    this.todoForm = this.createTodoForm();

                    this.todoForm.valueChanges
                        .pipe(
                            takeUntil(this._unsubscribeAll),
                            debounceTime(500),
                            distinctUntilChanged()
                        )
                        .subscribe(data => {
                            this._todoService.updateTodo(data);
                        });
                }
            });

        // Subscribe to update on tag change
        this._todoService.onTagsChanged
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(labels => {
                this.tags = labels;
            });

        // Subscribe to update on tag change
        this._todoService.onNewTodoClicked
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.todo = new class implements Task {
                    createdAt: Date;
                    dateFrom: Date;
                    dateTo: Date;
                    done: boolean;
                    draft: boolean;
                    entityDescription: string;
                    id: number;
                    message: string;
                    parentToken: any;
                    sendNotification: boolean;
                    subject: string;
                    updatedAt: Date;
                    user: any;
                    version: number;
                };
                this.todo.id = +FuseUtils.generateGUID();
                this.formType = 'new';
                this.todoForm = this.createTodoForm();
                this.focusTitleField();
                this._todoService.onCurrentTodoChanged.next([this.todo, 'new']);
            });
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void
    {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Focus title field
     */
    focusTitleField(): void
    {
        setTimeout(() => {
            this.titleInputField.nativeElement.focus();
        });
    }

    /**
     * Create todo form
     *
     * @returns {FormGroup}
     */
    createTodoForm(): FormGroup
    {
        return this._formBuilder.group({
            id       : [this.todo.id],
            subject    : [this.todo.subject],
            message    : [this.todo.message],
            dateFrom: [this.todo.dateFrom],
            dateTo  : [this.todo.dateTo],
            done: [this.todo.done],
            user: [this.todo.user]
        });
    }

    /**
     * Toggle star
     *
     * @param event
     */
    // toggleStar(event): void
    // {
    //     event.stopPropagation();
    //     this.todo.toggleStar();
    //     this._todoService.updateTodo(this.todo);
    // }

    /**
     * Toggle important
     *
     * @param event
     */
    // toggleImportant(event): void
    // {
    //     event.stopPropagation();
    //     this.todo.toggleImportant();
    //     this._todoService.updateTodo(this.todo);
    // }

    /**
     * Toggle Completed
     *
     * @param event
     */
    toggleCompleted(event): void
    {
        event.stopPropagation();
        this.done = !this.done;
        this.addTodo();
    }

    /**
     * Toggle Deleted
     *
     * @param event
     */
    toggleDeleted(event): void
    {
        this.toggleCompleted(event)
    }

    /**
     * Toggle tag on todo
     *
     * @param tagId
     */
    // toggleTagOnTodo(tagId): void
    // {
    //     this._todoService.toggleTagOnTodo(tagId, this.todo);
    // }

    /**
     * Has tag?
     *
     * @param tagId
     * @returns {any}
     */
    // hasTag(tagId): any
    // {
    //     return this._todoService.hasTag(tagId, this.todo);
    // }

    /**
     * Add todo
     */
    addTodo(): void
    {
        let raw = this.todoForm.getRawValue()
        console.log(raw)
        raw['done'] = this.done;
        raw['user'] = JSON.parse(localStorage.getItem('user'));

        this._todoService.updateTodo(raw);
    }
}
