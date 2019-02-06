Create the procedure
---------------------------
DROP PROCEDURE IF EXISTS dbjdbc.test_proc;
CREATE PROCEDURE dbjdbc.test_proc(
    in input_param_1 int,
    in input_param_2 int,
    in input_param_3 int,
    out output_sum int,
    out output_product int,
    out output_average int
)
BEGIN
    set output_sum = input_param_1 + input_param_2 + input_param_3;
    set output_product = input_param_1 * input_param_2 * input_param_3;
    set output_average = (input_param_1 + input_param_2 + input_param_3) / 3;
END

Call the Procedure
--------------------------------
set @procOutput_sum=0;
set @procOutput_product =0;
set @procOutput_average =0;
call dbjdbc.test_proc(10, 20, 30, @procOutput_sum, @procOutput_product, @procOutput_average);
select @procOutput_sum sum,@procOutput_product product,@procOutput_average average;

