import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ApiList() {
    const [ApiTests, setApiTests] = useState([]);

    useEffect(() => {
        axios.get('/api/test')
            .then(response => {
                setApiTests(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }, []);

    return (
        <div>
            <h1>ApiTest List</h1>
            <ul>
                {ApiTests.map(test => (
                    <li key={test.id}>{test.name}</li>
                ))}
            </ul>
        </div>
    );
}
