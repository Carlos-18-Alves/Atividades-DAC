/* eslint-disable import/no-anonymous-default-export */
import React from "react";

export default props => {

    const rows = props.agendas.map( agenda => {
        return (
            <tr key={agenda.id}>
                <td>{agenda.id}</td>
                <td>{agenda.eventName}</td>
                <td>{agenda.date.day}</td>
                <td>{agenda.date.month}</td>
                <td>{agenda.date.year}</td>
                <td>
                    <button type="button" title="Edit"
                            className="btn btn-primary"
                            onClick={e => props.edit(agenda.id)}>
                            <i className="pi pi-pencil"></i>
                    </button>
                    <button type="button" title="Delete"
                            className="btn btn-danger"
                            onClick={e => props.delete(agenda.id)}>
                            <i className="pi pi-trash"></i>
                    </button>
                </td>
            </tr>
        )
    })

    return (
        <table className="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Event Name</th>
                    <th scope="col">Day</th>
                    <th scope="col">Month</th>
                    <th scope="col">Year</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {rows}
            </tbody>
        </table>
    )
}