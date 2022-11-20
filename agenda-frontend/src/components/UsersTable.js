/* eslint-disable import/no-anonymous-default-export */
import React from 'react';

export default props => {

    const rows = props.users.map( user => {
        return (
            <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.username}</td>
                <td>
                    <button type="button"   title="Edit"
                            className="btn btn-primary"
                            onClick={e => props.edit(user.id)}>
                            <i className="pi pi-pencil"></i>
                    </button>
                    <button type="button"  title="Delete"
                            className="btn btn-danger" 
                            onClick={ e => props.delete(user.id)}>
                            <i className="pi pi-trash"></i>
                    </button>
                </td>
            </tr>
        )
    } )

    return (
        <table className="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Username</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {rows}
            </tbody>
        </table>
    )
}