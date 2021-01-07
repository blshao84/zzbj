#!/bin/bash
cd python
mkdir log
export PYTHONPATH=$(pwd)
cd test
echo "running smoke test ..."
eval "pytest -x"